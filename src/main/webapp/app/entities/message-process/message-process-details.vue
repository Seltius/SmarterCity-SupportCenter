<template>
  <div class="row justify-content-center">
    <div class="col-10">
      <div v-if="messageProcess.processInstance">
        <h2 class="jh-entity-heading" data-cy="messageProcessDetailsHeading">
          <span v-text="$t('smarterCitySupportCenterApp.messageProcess.detail.title')">MessageProcess</span> {{ messageProcess.id }}
        </h2>
        <akip-show-process-instance :processInstance="messageProcess.processInstance">
          <template v-slot:title>
            <span v-text="$t('smarterCitySupportCenterApp.messageProcess.detail.title')">MessageProcess</span> #{{ messageProcess.id }}
          </template>
          <template v-slot:details>
            <div class="card" v-if="messageProcess.message">
              <h5 class="card-header">
                <span class="title"> Message #{{ messageProcess.message.id }} </span>
              </h5>
              <div class="card-body py-0">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('smarterCitySupportCenterApp.messageProcess.supportId')">supportId</label>
                  <input
                    readonly
                    type="text"
                    class="form-control"
                    name="supportId"
                    id="message-supportId"
                    data-cy="supportId"
                    v-model="messageProcess.message.supportId"
                  />
                </div>
              </div>
              <div class="card-body py-0">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('smarterCitySupportCenterApp.messageProcess.date')">date</label>
                  <input
                    readonly
                    type="text"
                    class="form-control"
                    name="date"
                    id="message-date"
                    data-cy="date"
                    v-model="messageProcess.message.date"
                  />
                </div>
              </div>
              <div class="card-body py-0">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('smarterCitySupportCenterApp.messageProcess.messageType')"
                    >messageType</label
                  >
                  <input
                    readonly
                    type="text"
                    class="form-control"
                    name="messageType"
                    id="message-messageType"
                    data-cy="messageType"
                    v-model="messageProcess.message.messageType"
                  />
                </div>
              </div>
              <div class="card-body py-0">
                <div class="form-group">
                  <label class="form-control-label" v-text="$t('smarterCitySupportCenterApp.messageProcess.value')">value</label>
                  <input
                    readonly
                    type="text"
                    class="form-control"
                    name="value"
                    id="message-value"
                    data-cy="value"
                    v-model="messageProcess.message.value"
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

<script lang="ts" src="./message-process-details.component.ts"></script>
