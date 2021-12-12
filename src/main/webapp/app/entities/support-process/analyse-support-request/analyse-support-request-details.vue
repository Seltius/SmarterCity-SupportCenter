<template>
  <div class="row justify-content-center">
    <div class="col-10">
      <h2 id="page-heading" data-cy="TaskInstanceHeading">
        <span v-text="$t('smarterCitySupportCenterApp.taskInstance.details.title')" id="task-instance-heading">Task Details</span>
      </h2>
      <div v-if="taskContext.taskInstance">
        <akip-show-task-instance :taskInstance="taskContext.taskInstance">
          <template v-slot:body>
            <hr />
            <div class="form-group">
              <label class="form-control-label" v-text="$t('smarterCitySupportCenterApp.analyseSupportRequest.supportId')">supportId</label>
              <input
                readonly
                type="text"
                class="form-control"
                name="supportId"
                id="support-supportId"
                data-cy="supportId"
                v-model="taskContext.supportProcess.support.supportId"
              />
            </div>
            <div class="form-group">
              <label class="form-control-label" v-text="$t('smarterCitySupportCenterApp.analyseSupportRequest.createDate')"
                >createDate</label
              >
              <input
                readonly
                type="text"
                class="form-control"
                name="createDate"
                id="support-createDate"
                data-cy="createDate"
                v-model="taskContext.supportProcess.support.createDate"
              />
            </div>
            <div class="form-group">
              <label class="form-control-label" v-text="$t('smarterCitySupportCenterApp.analyseSupportRequest.name')">name</label>
              <input
                readonly
                type="text"
                class="form-control"
                name="name"
                id="support-name"
                data-cy="name"
                v-model="taskContext.supportProcess.support.name"
              />
            </div>
            <div class="form-group">
              <label class="form-control-label" v-text="$t('smarterCitySupportCenterApp.analyseSupportRequest.email')">email</label>
              <input
                readonly
                type="text"
                class="form-control"
                name="email"
                id="support-email"
                data-cy="email"
                v-model="taskContext.supportProcess.support.email"
              />
            </div>
            <div class="form-group">
              <label class="form-control-label" v-text="$t('smarterCitySupportCenterApp.analyseSupportRequest.issue')">issue</label>
              <input
                readonly
                type="text"
                class="form-control"
                name="issue"
                id="support-issue"
                data-cy="issue"
                v-model="taskContext.supportProcess.support.issue"
              />
            </div>
            <div class="form-group">
              <label class="form-control-label" v-text="$t('smarterCitySupportCenterApp.analyseSupportRequest.isRefund')">isRefund</label>
              <input
                readonly
                type="text"
                class="form-control"
                name="isRefund"
                id="support-isRefund"
                data-cy="isRefund"
                v-model="taskContext.supportProcess.support.isRefund"
              />
            </div>
          </template>
        </akip-show-task-instance>
        <br />
        <button type="submit" v-on:click.prevent="previousState()" class="btn btn-info" data-cy="entityDetailsBackButton">
          <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.back')"> Back</span>
        </button>

        <router-link
          v-if="taskContext.taskInstance.status == 'NEW' || taskContext.taskInstance.status == 'ASSIGNED'"
          :to="`/process-definition/SupportProcess/task/AnalyseSupportRequest/${taskContext.taskInstance.id}/execute`"
          tag="button"
          class="btn btn-primary"
          data-cy="entityDetailsButton"
        >
          <font-awesome-icon icon="play"></font-awesome-icon>&nbsp;Execute
        </router-link>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./analyse-support-request-details.component.ts"></script>
