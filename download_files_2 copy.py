from playwright.sync_api import sync_playwright
import subprocess
import time
import os

FIREFOX_PROFILE_D = '/home/alexa/.mozilla/firefox/alexa'

with sync_playwright() as p:
    browser = p.firefox.launch_persistent_context(
        user_data_dir=FIREFOX_PROFILE_D,
        headless=False
    )
    page = browser.new_page()
    
    page.goto('https://www.google.com')
    
    input()
    print("Cook", page.context.cookies())
    
    input()
    browser.close()