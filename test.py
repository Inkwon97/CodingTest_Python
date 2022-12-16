import requests
target = "http://google.com"

request = requests.get(url=target)

html = requests.text.strip()

print(html)