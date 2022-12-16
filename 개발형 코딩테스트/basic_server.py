from flask import Flask

app = Flask(__name__)

@app.route('/')
@app.route('/home')
def home():
  return 'Hello, World!'

@app.route('/board')
def board():
  return 'This is a board page'

if __name__ == '__main__':
  app.run()