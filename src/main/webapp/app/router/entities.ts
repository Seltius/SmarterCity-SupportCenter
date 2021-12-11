import { Authority } from '@/shared/security/authority';
/* tslint:disable */
// prettier-ignore

// prettier-ignore
const SupportStartFormInit = () => import('@/entities/support-process/support-start-form-init.vue');
// prettier-ignore
const Refund = () => import('@/entities/refund/refund.vue');
// prettier-ignore
const RefundDetails = () => import('@/entities/refund/refund-details.vue');
// prettier-ignore
const Support = () => import('@/entities/support/support.vue');
// prettier-ignore
const SupportDetails = () => import('@/entities/support/support-details.vue');
// prettier-ignore
const SupportProcessDetails = () => import('@/entities/support-process/support-process-details.vue');
// prettier-ignore
const SupportProcessList = () => import('@/entities/support-process/support-process-list.vue');
// prettier-ignore
const RefundProcessDetails = () => import('@/entities/refund-process/refund-process-details.vue');
// prettier-ignore
const RefundProcessList = () => import('@/entities/refund-process/refund-process-list.vue');
// prettier-ignore
const SupportProcess_FillSupportRequestDetails = () => import('@/entities/support-process/fill-support-request/fill-support-request-details.vue');
// prettier-ignore
const SupportProcess_FillSupportRequestExecute = () => import('@/entities/support-process/fill-support-request/fill-support-request-execute.vue');
// prettier-ignore
const SupportProcess_AnalyseSupportRequestDetails = () => import('@/entities/support-process/analyse-support-request/analyse-support-request-details.vue');
// prettier-ignore
const SupportProcess_AnalyseSupportRequestExecute = () => import('@/entities/support-process/analyse-support-request/analyse-support-request-execute.vue');
// jhipster-needle-add-entity-to-router-import - JHipster will import entities to the router here

export default [
  {
    path: '/process-definition/SupportProcess/init',
    name: 'SupportStartFormInit',
    component: SupportStartFormInit,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/refund',
    name: 'Refund',
    component: Refund,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/refund/:refundId/view',
    name: 'RefundView',
    component: RefundDetails,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/support',
    name: 'Support',
    component: Support,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/support/:supportId/view',
    name: 'SupportView',
    component: SupportDetails,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/process-definition/SupportProcess/instance/:processInstanceId/view',
    name: 'SupportProcessView',
    component: SupportProcessDetails,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/process-definition/SupportProcess/instances',
    name: 'SupportProcessList',
    component: SupportProcessList,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/process-definition/SupportProcess/instance/:processInstanceId/view',
    name: 'RefundProcessView',
    component: RefundProcessDetails,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/process-definition/SupportProcess/instances',
    name: 'RefundProcessList',
    component: RefundProcessList,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/process-definition/SupportProcess/task/FillSupportRequest/:taskInstanceId/view',
    name: 'SupportProcess_FillSupportRequestDetails',
    component: SupportProcess_FillSupportRequestDetails,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/process-definition/SupportProcess/task/FillSupportRequest/:taskInstanceId/execute',
    name: 'SupportProcess_FillSupportRequestExecute',
    component: SupportProcess_FillSupportRequestExecute,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/process-definition/SupportProcess/task/AnalyseSupportRequest/:taskInstanceId/view',
    name: 'SupportProcess_AnalyseSupportRequestDetails',
    component: SupportProcess_AnalyseSupportRequestDetails,
    meta: { authorities: [Authority.USER] },
  },
  {
    path: '/process-definition/SupportProcess/task/AnalyseSupportRequest/:taskInstanceId/execute',
    name: 'SupportProcess_AnalyseSupportRequestExecute',
    component: SupportProcess_AnalyseSupportRequestExecute,
    meta: { authorities: [Authority.USER] },
  },
  // jhipster-needle-add-entity-to-router - JHipster will add entities to the router here
];
