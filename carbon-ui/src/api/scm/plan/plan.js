import request from '@/utils/request'

// 查询供应链SCM-采购管理-采购计划列表
export function listPlan(query) {
  return request({
    url: '/plan/plan/list',
    method: 'get',
    params: query
  })
}

// 查询供应链SCM-采购管理-采购计划详细
export function getPlan(id) {
  return request({
    url: '/plan/plan/' + id,
    method: 'get'
  })
}

// 新增供应链SCM-采购管理-采购计划
export function addPlan(data) {
  return request({
    url: '/plan/plan',
    method: 'post',
    data: data
  })
}

// 修改供应链SCM-采购管理-采购计划
export function updatePlan(data) {
  return request({
    url: '/plan/plan',
    method: 'put',
    data: data
  })
}

// 删除供应链SCM-采购管理-采购计划
export function delPlan(id) {
  return request({
    url: '/plan/plan/' + id,
    method: 'delete'
  })
}
