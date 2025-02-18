from playwright.sync_api import sync_playwright

debug_port = 9222  # Must match the port used to start Edge

with sync_playwright() as p:
    browser = p.chromium.connect_over_cdp(f'http://localhost:{debug_port}')
    page = browser.new_page()
    
    page.goto('https://www.google.com')
    print("Cookies:", page.context.cookies())
    
    input("Press Enter to close...")
    browser.close()
