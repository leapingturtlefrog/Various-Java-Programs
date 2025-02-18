# NOT Java

from playwright.sync_api import sync_playwright
import subprocess
import time
import os
import zipfile
import sys

FIREFOX_PROFILE_D = '/home/alexa/.mozilla/firefox/sebcv9x3.default-default-6'

destination_d = '/mnt/c/Users/alexa/c/cs1332/src/test/java'
urls = []

if len(sys.argv) > 1:
    urls = sys.argv[1:]
elif not len(urls) > 0:
    exit(1)

with sync_playwright() as p:
    browser = p.firefox.launch_persistent_context(
        user_data_dir=FIREFOX_PROFILE_D,
        headless=True
    )
    page = browser.new_page()
    browser.pages[0].close()
    for url in urls:
        page.goto(url)
        page.wait_for_timeout(3000)
        
        with page.expect_download() as download_info:
            buttons = page.locator('a:has-text("Download ZIP")')
            buttons.nth(1).click()
        download = download_info.value
        
        zip_d = download.path()
        zip_f = os.path.basename(download.suggested_filename)
        zip_dest_d = os.path.join('/home/alexa/downloads', zip_f)
        download.save_as(zip_dest_d)
        
        with zipfile.ZipFile(zip_dest_d, 'r') as zip_ref:
            for member in zip_ref.namelist():
                if not member.endswith('/'):
                    f = os.path.basename(member)
                    target_d = os.path.join(destination_d, f)
                    with zip_ref.open(member) as source, open(target_d, 'wb') as target:
                        target.write(source.read())
    
    browser.close()