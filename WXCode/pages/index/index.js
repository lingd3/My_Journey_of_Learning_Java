//index.js
//获取应用实例
const app = getApp()

Page({
  data: {
    imgUrls: [
      '/images/swiper01.jpg',
      '/images/swiper02.jpg',
      '/images/swiper03.jpg',
    ],
    indicatorDots: false,
    autoplay: false,
    interval: 5000,
    duration: 1000,
    // proList: null,
    proList: [
      {
        logo: '/images/banner_01.jpg',
        title: 'sdfssdf',
        desc: 'sdfsdf',
      },
      {
        logo: '/images/banner_02.jpg',
        title: 'sdfssdf',
        desc: 'sdfsdf',
      },
      {
        logo: '/images/banner_03.jpg',
        title: 'sdfssdf',
        desc: 'sdfsdf',
      },
    ]
  },

  //事件处理函数
  onLoad: function() {
    // this.getProList();
  },

  toDetail: function(e) {
    
  },

  // getProList: function() {
  //   var self = this;
  //   wx.request({
  //     url: 'http://localhost:8080/',
  //     method: 'GET',
  //     success: function(res) {
  //       console.log(res);
  //       self.setData({
  //         proList: res.data;
  //       })
  //     }
  //   })
  // }



})
