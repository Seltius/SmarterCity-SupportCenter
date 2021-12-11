<template>
  <div class="row justify-content-center">
    <div class="col-10">
      <div v-if="refundProcess.processInstance">
        <h2 class="jh-entity-heading" data-cy="refundProcessDetailsHeading">
          <span v-text="$t('smarterCitySupportCenterApp.refundProcess.detail.title')">RefundProcess</span> {{ refundProcess.id }}
        </h2>
        <akip-show-process-instance :processInstance="refundProcess.processInstance">
          <template v-slot:title>
            <span v-text="$t('smarterCitySupportCenterApp.refundProcess.detail.title')">RefundProcess</span> #{{ refundProcess.id }}
          </template>
          <template v-slot:details>
            <div class="card" v-if="refundProcess.refund">
              <h5 class="card-header">
                <span class="title"> Refund #{{ refundProcess.refund.id }} </span>
              </h5>
              <div class="card-body py-0">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('smarterCitySupportCenterApp.refundProcess.refundId')">refundId</label>
                  <input
                    readonly
                    type="text"
                    class="form-control"
                    name="refundId"
                    id="refund-refundId"
                    data-cy="refundId"
                    v-model="refundProcess.refund.refundId"
                  />
                </div>
              </div>
              <div class="card-body py-0">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('smarterCitySupportCenterApp.refundProcess.amount')">amount</label>
                  <input
                    readonly
                    type="text"
                    class="form-control"
                    name="amount"
                    id="refund-amount"
                    data-cy="amount"
                    v-model="refundProcess.refund.amount"
                  />
                </div>
              </div>
              <div class="card-body py-0">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('smarterCitySupportCenterApp.refundProcess.method')">method</label>
                  <input
                    readonly
                    type="text"
                    class="form-control"
                    name="method"
                    id="refund-method"
                    data-cy="method"
                    v-model="refundProcess.refund.method"
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

<script lang="ts" src="./refund-process-details.component.ts"></script>
