<template>
  <div class="row justify-content-center">
    <div class="col-10">
      <div v-if="supportProcess.processInstance">
        <h2 class="jh-entity-heading" data-cy="supportProcessDetailsHeading">
          <span v-text="$t('smarterCitySupportCenterApp.supportProcess.detail.title')">SupportProcess</span> {{ supportProcess.id }}
        </h2>
        <akip-show-process-instance :processInstance="supportProcess.processInstance">
          <template v-slot:title>
            <span v-text="$t('smarterCitySupportCenterApp.supportProcess.detail.title')">SupportProcess</span> #{{ supportProcess.id }}
          </template>
          <template v-slot:details>
            <div class="card" v-if="supportProcess.support">
              <h5 class="card-header">
                <span class="title"> Support #{{ supportProcess.support.id }} </span>
              </h5>
              <div class="card-body py-0">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('smarterCitySupportCenterApp.supportProcess.supportId')">supportId</label>
                  <input
                    readonly
                    type="text"
                    class="form-control"
                    name="supportId"
                    id="support-supportId"
                    data-cy="supportId"
                    v-model="supportProcess.support.supportId"
                  />
                </div>
              </div>
              <div class="card-body py-0">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('smarterCitySupportCenterApp.supportProcess.createDate')">createDate</label>
                  <input
                    readonly
                    type="text"
                    class="form-control"
                    name="createDate"
                    id="support-createDate"
                    data-cy="createDate"
                    v-model="supportProcess.support.createDate"
                  />
                </div>
              </div>
              <div class="card-body py-0">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('smarterCitySupportCenterApp.supportProcess.endDate')">endDate</label>
                  <input
                    readonly
                    type="text"
                    class="form-control"
                    name="endDate"
                    id="support-endDate"
                    data-cy="endDate"
                    v-model="supportProcess.support.endDate"
                  />
                </div>
              </div>
              <div class="card-body py-0">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('smarterCitySupportCenterApp.supportProcess.name')">name</label>
                  <input
                    readonly
                    type="text"
                    class="form-control"
                    name="name"
                    id="support-name"
                    data-cy="name"
                    v-model="supportProcess.support.name"
                  />
                </div>
              </div>
              <div class="card-body py-0">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('smarterCitySupportCenterApp.supportProcess.email')">email</label>
                  <input
                    readonly
                    type="text"
                    class="form-control"
                    name="email"
                    id="support-email"
                    data-cy="email"
                    v-model="supportProcess.support.email"
                  />
                </div>
              </div>
              <div class="card-body py-0">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('smarterCitySupportCenterApp.supportProcess.issue')">issue</label>
                  <input
                    readonly
                    type="text"
                    class="form-control"
                    name="issue"
                    id="support-issue"
                    data-cy="issue"
                    v-model="supportProcess.support.issue"
                  />
                </div>
              </div>
              <div class="card-body py-0">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('smarterCitySupportCenterApp.supportProcess.isRefund')">isRefund</label>
                  <input
                    readonly
                    type="text"
                    class="form-control"
                    name="isRefund"
                    id="support-isRefund"
                    data-cy="isRefund"
                    v-model="supportProcess.support.isRefund"
                  />
                </div>
              </div>
              <div class="card-body py-0">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('smarterCitySupportCenterApp.supportProcess.isValid')">isValid</label>
                  <input
                    readonly
                    type="text"
                    class="form-control"
                    name="isValid"
                    id="support-isValid"
                    data-cy="isValid"
                    v-model="supportProcess.support.isValid"
                  />
                </div>
              </div>
              <div class="card-body py-0">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('smarterCitySupportCenterApp.supportProcess.refundId')">refundId</label>
                  <input
                    readonly
                    type="text"
                    class="form-control"
                    name="refundId"
                    id="support-refundId"
                    data-cy="refundId"
                    v-model="supportProcess.support.refundId"
                  />
                </div>
              </div>
              <div class="card-body py-0">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('smarterCitySupportCenterApp.supportProcess.isResolved')">isResolved</label>
                  <input
                    readonly
                    type="text"
                    class="form-control"
                    name="isResolved"
                    id="support-isResolved"
                    data-cy="isResolved"
                    v-model="supportProcess.support.isResolved"
                  />
                </div>
              </div>
              <div class="card-body py-0">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('smarterCitySupportCenterApp.supportProcess.status')">status</label>
                  <input
                    readonly
                    type="text"
                    class="form-control"
                    name="status"
                    id="support-status"
                    data-cy="status"
                    v-model="supportProcess.support.status"
                  />
                </div>
              </div>
              <div class="card-body py-0">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('smarterCitySupportCenterApp.supportProcess.userReply')">userReply</label>
                  <input
                    readonly
                    type="text"
                    class="form-control"
                    name="userReply"
                    id="support-userReply"
                    data-cy="userReply"
                    v-model="supportProcess.support.userReply"
                  />
                </div>
              </div>
              <div class="card-body py-0">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('smarterCitySupportCenterApp.supportProcess.supportReply')"
                    >supportReply</label
                  >
                  <input
                    readonly
                    type="text"
                    class="form-control"
                    name="supportReply"
                    id="support-supportReply"
                    data-cy="supportReply"
                    v-model="supportProcess.support.supportReply"
                  />
                </div>
              </div>
            </div>
          </template>
        </akip-show-process-instance>
        <br />
        <button type="submit" v-on:click.prevent="previousState()" class="btn btn-info" data-cy="entityDetailsBackButton">
          <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.back')"> Back</span>
        </button>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./support-process-details.component.ts"></script>
