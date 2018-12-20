Page({
  datas:{

  },

  onLoad:function(options){
    //console.log(options.id)
    this.setData({
      mid:options.id
    })
    var that=this

    wx.request({
      url: 'https://liudongtushuguan.cn/v2/movie/subject'+options.id,
      header:{
        "content-type":"json"
      },
      success:function(res){
        console.log(res)
        if(res.statusCode==200){
          that.setData({
            movie: res.data
          })
          wx.setNavigationBarTitle({
            title: 'rs.data.rating.average ++"分："+res.data.title',
          })
          wx.hideNavigationBarLoading()
        }
      }
    })
    wx.showNavigationBarLoading()
  },
  onShareAppMessage: function () {
    return {
      title: "向你推荐："+this.data.movie.title
    }
  }
})