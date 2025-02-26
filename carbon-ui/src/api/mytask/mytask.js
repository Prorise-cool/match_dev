import request from '@/utils/request'

// 查询智能仓储WMS-出库申请列表
export function listMytask(query) {
  return request({
    url: '/mytask/mytask/list',
    method: 'get',
    params: query
  })
}

// 查询智能仓储WMS-出库申请详细
export function getMytask(id) {
  return request({
    url: '/mytask/mytask/' + id,
    method: 'get'
  })
}

// 新增智能仓储WMS-出库申请
export function addMytask(data) {
  return request({
    url: '/mytask/mytask',
    method: 'post',
    data: data
  })
}

// 修改智能仓储WMS-出库申请
export function updateMytask(data) {
  return request({
    url: '/mytask/mytask',
    method: 'put',
    data: data
  })
}

// 删除智能仓储WMS-出库申请
export function delMytask(id) {
  return request({
    url: '/mytask/mytask/' + id,
    method: 'delete'
  })
}
