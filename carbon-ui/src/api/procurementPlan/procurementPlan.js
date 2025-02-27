import request from '@/utils/request'

// 查询供应链SCM-采购管理-采购计划列表
export function listProcurementPlan(query) {
  return request({
    url: '/procurementPlan/procurementPlan/list',
    method: 'get',
    params: query
  })
}

// 查询供应链SCM-采购管理-采购计划详细
export function getProcurementPlan(id) {
  return request({
    url: '/procurementPlan/procurementPlan/' + id,
    method: 'get'
  })
}

// 新增供应链SCM-采购管理-采购计划
export function addProcurementPlan(data) {
  return request({
    url: '/procurementPlan/procurementPlan',
    method: 'post',
    data: data
  })
}

// 修改供应链SCM-采购管理-采购计划
export function updateProcurementPlan(data) {
  return request({
    url: '/procurementPlan/procurementPlan',
    method: 'put',
    data: data
  })
}

// 删除供应链SCM-采购管理-采购计划
export function delProcurementPlan(id) {
  return request({
    url: '/procurementPlan/procurementPlan/' + id,
    method: 'delete'
  })
}
