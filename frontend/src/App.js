import './App.css';
import axios from 'axios';
import React from 'react';
import './App.css';
import {login} from "./login.js";

class App extends React.Component{
  constructor(props) {
    super(props);
    this.state = {
      //内网穿透工具介绍:
      // https://developers.dingtalk.com/document/resourcedownload/http-intranet-penetration?pnamespace=app
      domain: "",
      corpId: '',
      authCode: '',
      userId: '',
      userName: ''
    }
  }
  render() {
    if(this.state.userId === ''){
      // 免登操作
      login();
    }
    return (
        // 主模块
        <div className="App">

        </div>
    );
  }
}

export default App;
