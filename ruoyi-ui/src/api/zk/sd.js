import request from '@/utils/request'

// 查询sd列表
export function listSd(query) {
  return request({
    url: '/zk/sd/list',
    method: 'get',
    params: query
  })
}

// 查询sd详细
export function getSd(id) {
  return request({
    url: '/zk/sd/' + id,
    method: 'get'
  })
}

// 新增sd
export function addSd(data) {
  return request({
    url: '/zk/sd',
    method: 'post',
    data: data
  })
}

// 修改sd
export function updateSd(data) {
  return request({
    url: '/zk/sd',
    method: 'put',
    data: data
  })
}

// 删除sd
export function delSd(id) {
  return request({
    url: '/zk/sd/' + id,
    method: 'delete'
  })
}

// 导出sd
export function exportSd(query) {
  return request({
    url: '/zk/sd/export',
    method: 'get',
    params: query
  })
}