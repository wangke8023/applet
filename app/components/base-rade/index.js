/**
 * Copyright (C) 2018-2019
 * All rights reserved, Designed By www.wwl.com
 * 注意：
 * 本软件为www.wwl.com开发研制，项目使用请保留此说明
 */
Component({
  properties: {
    value: {
      type: Number,
      value: 0
    },
    size: {
      type: String,
      value: 'xxl'
    }
  },
  data: {

  },
  methods: {
    redeHander(e){
      let value = e.currentTarget.dataset.index + 1
      this.setData({
        value: value
      })
      this.triggerEvent('onChange', value)
    }
  }
})