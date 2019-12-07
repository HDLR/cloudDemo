import Vue from 'vue'
import axios from 'axios'
import router from '@/router'
import qs from 'qs'
import merge from 'lodash/merge'
import { clearLoginInfo } from '@/utils'

const http = axios.create({
  timeout: 1000 * 30,
  withCredentials: true,
  headers: {
    'Content-Type': 'application/json; charset=utf-8'
  }
})

/**
 * 请求拦截
 */
http.interceptors.request.use(config => {
    // let authorization = Vue.cookie.get('Authorization')
    // console.log('Authorization', authorization)
    // if(authorization){
    //     config.headers['Authorization'] = authorization // 请求头带上token
    //     // config.headers['Authorization'] = 'bearer ' + Vue.cookie.get('Authorization') // 请求头带上token
    // }
    return config
}, error => {
    return Promise.reject(error)
})

/**
 * 响应拦截
 */
http.interceptors.response.use(response => {
    return response
}, error => {

    console.log('异常信息-----------------------------------------start')
    let resMsg = "请求异常"
    console.log(error)
    console.log(error.response.data)
    if(error.response && error.response.data){
        if(error.response.data.code === '401'){
            // console.log('跳转到登录地址')
            // gotoLogin()
            // return
        }else if(error.response.data.message){
            resMsg = error.response.data.message
            // if("用户未登录" === resMsg){
            //     console.log('跳转到登录地址')
            //     gotoLogin()
            //     return
            // }
        }
    }
    Vue.prototype.$message.error(resMsg)
    console.log('异常信息-------------------------------------------end')

  return Promise.reject(error)
})

function gotoLogin () {
    const httpLogin = process.env.VUE_APP_AC_HTTP_LOGIN
    let url = `${httpLogin}?redirect_url=${encodeURIComponent(location.href)}`
    location.href = url
}

/**
 * 请求地址处理
 * @param {*} actionName action方法名称
 */
http.adornUrl = (actionName) => {
  // 非生产环境 && 开启代理, 接口前缀统一使用[/proxyApi/]前缀做代理拦截!
  // return (process.env.NODE_ENV !== 'production' && process.env.OPEN_PROXY ? '/proxyApi/' : window.SITE_CONFIG.baseUrl) + actionName
  return process.env.VUE_APP_TAG_SERVER_URL + actionName
}

/**
 * get请求参数处理
 * @param {*} params 参数对象
 * @param {*} openDefultParams 是否开启默认参数?
 */
http.adornParams = (params = {}, openDefultParams = true) => {
  var defaults = {
    't': new Date().getTime()
  }
  return openDefultParams ? merge(defaults, params) : params
}

/**
 * post请求数据处理
 * @param {*} data 数据对象
 * @param {*} openDefultdata 是否开启默认数据?
 * @param {*} contentType 数据格式
 *  json: 'application/json; charset=utf-8'
 *  form: 'application/x-www-form-urlencoded; charset=utf-8'
 */
http.adornData = (data = {}, openDefultdata = true, contentType = 'json') => {
  var defaults = {
    't': new Date().getTime()
  }
  data = openDefultdata ? merge(defaults, data) : data
  return contentType === 'json' ? JSON.stringify(data) : qs.stringify(data)
}

export default http
