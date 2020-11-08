import request from '@/utils/request'

// 查询renter列表
export function listRenter(query) {
  return request({
    url: '/zk/renter/list',
    method: 'get',
    params: query
  })
}

// 查询renter详细
export function getRenter(id) {
  return request({
    url: '/zk/renter/' + id,
    method: 'get'
  })
}

// 新增renter
export function addRenter(data) {
  return request({
    url: '/zk/renter',
    method: 'post',
    data: data
  })
}

// 修改renter
export function updateRenter(data) {
  return request({
    url: '/zk/renter',
    method: 'put',
    data: data
  })
}

// 删除renter
export function delRenter(id) {
  return request({
    url: '/zk/renter/' + id,
    method: 'delete'
  })
}

// 导出renter
export function exportRenter(query) {
  return request({
    url: '/zk/renter/export',
    method: 'get',
    params: query
  })
}



//通过房屋id 来查找 租客
export function listRenterByHouseId(id) {
  return request({
    url: '/zk/renter/houseId/' + id,
    method: 'get'
  })
}
