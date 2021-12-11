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
                  <label class="form-control-label" v-text="$t('smarterCitySupportCenterApp.supportProcess.startDate')">startDate</label>
                  <input
                    readonly
                    type="text"
                    class="form-control"
                    name="startDate"
                    id="support-startDate"
                    data-cy="startDate"
                    v-model="supportProcess.support.startDate"
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
                  <label class="form-control-label" v-text="$t('smarterCitySupportCenterApp.supportProcess.userName')">userName</label>
                  <input
                    readonly
                    type="text"
                    class="form-control"
                    name="userName"
                    id="support-userName"
                    data-cy="userName"
                    v-model="supportProcess.support.userName"
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
                  <label class="form-control-label" v-text="$t('smarterCitySupportCenterApp.supportProcess.message')">message</label>
                  <input
                    readonly
                    type="text"
                    class="form-control"
                    name="message"
                    id="support-message"
                    data-cy="message"
                    v-model="supportProcess.support.message"
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
                  <label class="form-control-label" v-text="$t('smarterCitySupportCenterApp.supportProcess.supportMessage')"
                    >supportMessage</label
                  >
                  <input
                    readonly
                    type="text"
                    class="form-control"
                    name="supportMessage"
                    id="support-supportMessage"
                    data-cy="supportMessage"
                    v-model="supportProcess.support.supportMessage"
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
