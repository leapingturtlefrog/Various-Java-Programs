# NOT Java

from playwright.sync_api import sync_playwright
import anyio
import time

CHROME_F = '/mnt/c/Program Files/Google/Chrome/Application/chrome.exe'
DEFAULT_PROFILE_D = '/mnt/c/Users/alexa/AppData/Local/Google/Chrome/User Data/Default'

urls = '''https://github.gatech.edu/gist/vparikh35/9645bc4a495e8672c1ef87d2bcea6c87
https://github.gatech.edu/gist/vparikh35/5e08aba08557b4648dfdb2ea6eb30231
https://github.gatech.edu/gist/vparikh35/1fb55eafbfbdc3147cf11eacc6bfa77a
https://github.gatech.edu/gist/vparikh35/b330c3692a911e60b1dbeee6c0a56a4b
https://github.gatech.edu/gist/vparikh35/306289a872c47477c4c956846305c711
https://github.gatech.edu/gist/vparikh35/0d8b81d26610c5d11e4cd59d897b1db5
https://github.gatech.edu/gist/vparikh35/4a1d1271f56c8f4e9969b77b71a6412e'''

def main():
    with sync_playwright() as p:
        browser = p.chromium.launch(
            
            user_data_dir=DEFAULT_PROFILE_D,
            executable_path=CHROME_F,
            headless=False
        )
        context = browser.new_context()
        page = context.new_page()
        for url in urls.split('\n'):
            page.goto(url)
            input()
            print(page.inner_text())
            

if __name__ == '__main__':
    main()