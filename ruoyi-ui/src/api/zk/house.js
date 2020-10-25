import request from '@/utils/request'

// 查询house列表
export function listHouse(query) {
  return request({
    url: '/zk/house/list',
    method: 'get',
    params: query
  })
}

// 查询house详细
export function getHouse(id) {
  return request({
    url: '/zk/house/' + id,
    method: 'get'
  })
}

// 新增house
export function addHouse(data) {
  return request({
    url: '/zk/house',
    method: 'post',
    data: data
  })
}

// 修改house
export function updateHouse(data) {
  return request({
    url: '/zk/house',
    method: 'put',
    data: data
  })
}

// 删除house
export function delHouse(id) {
  return request({
    url: '/zk/house/' + id,
    method: 'delete'
  })
}

// 导出house
export function exportHouse(query) {
  return request({
    url: '/zk/house/export',
    method: 'get',
    params: query
  })
}
//通过城市id 来查找 house

export function listHouseByCityId(id) {
  return request({
    url: '/zk/house/cityid/' + id,
    method: 'get'
  })
}
