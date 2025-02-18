from playwright.sync_api import sync_playwright
import subprocess
import time
import os

EDGE_F = '/mnt/c/Program Files (x86)/Microsoft/Edge/Application/msedge.exe'
EDGE_DEFAULT_PROFILE_D = '/mnt/c/Users/alexa/AppData/Local/Microsoft/Edge/User Data/Default'
CHROME_F = '/mnt/c/Program Files/Google/Chrome/Application/chrome.exe'
DEFAULT_PROFILE_D = '/mnt/c/Users/alexa/AppData/Local/Google/Chrome/User Data/Default'

windows_ip = os.popen("grep -m 1 nameserver /etc/resolv.conf | awk '{print $2}'").read().strip()
print(windows_ip)
debug_port = 9222
# chrome_command = f'"{EDGE_F}" --remote-debugging-port={debug_port}'

# subprocess.Popen(chrome_command, shell=True)
time.sleep(2)

with sync_playwright() as p:
    browser = p.chromium.connect_over_cdp(f'http://{windows_ip}:{debug_port}')
    page = browser.new_page()
    
    page.goto('https://www.google.com')
    input()
    print("Cook", page.context.cookies())
    
    input()
    browser.close()