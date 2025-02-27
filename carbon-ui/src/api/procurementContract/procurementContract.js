import request from '@/utils/request'

// 查询供应链SCM-销售管理-采购合同审核列表
export function listProcurementContract(query) {
  return request({
    url: '/procurementContract/procurementContract/list',
    method: 'get',
    params: query
  })
}

// 查询供应链SCM-销售管理-采购合同审核详细
export function getProcurementContract(id) {
  return request({
    url: '/procurementContract/procurementContract/' + id,
    method: 'get'
  })
}

// 新增供应链SCM-销售管理-采购合同审核
export function addProcurementContract(data) {
  return request({
    url: '/procurementContract/procurementContract',
    method: 'post',
    data: data
  })
}

// 修改供应链SCM-销售管理-采购合同审核
export function updateProcurementContract(data) {
  return request({
    url: '/procurementContract/procurementContract',
    method: 'put',
    data: data
  })
}

// 删除供应链SCM-销售管理-采购合同审核
export function delProcurementContract(id) {
  return request({
    url: '/procurementContract/procurementContract/' + id,
    method: 'delete'
  })
}
