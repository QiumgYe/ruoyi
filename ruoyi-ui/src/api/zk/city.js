import request from '@/utils/request'

// 查询city列表
export function listCity(query) {
  return request({
    url: '/zk/city/list',
    method: 'get',
    params: query
  })
}

// 查询city详细
export function getCity(id) {
  return request({
    url: '/zk/city/' + id,
    method: 'get'
  })
}

// 新增city
export function addCity(data) {
  return request({
    url: '/zk/city',
    method: 'post',
    data: data
  })
}

// 修改city
export function updateCity(data) {
  return request({
    url: '/zk/city',
    method: 'put',
    data: data
  })
}

// 删除city
export function delCity(id) {
  return request({
    url: '/zk/city/' + id,
    method: 'delete'
  })
}

// 导出city
export function exportCity(query) {
  return request({
    url: '/zk/city/export',
    method: 'get',
    params: query
  })
}