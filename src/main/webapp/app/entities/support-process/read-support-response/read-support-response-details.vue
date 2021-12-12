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
              <label class="form-control-label" v-text="$t('smarterCitySupportCenterApp.readSupportResponse.supportId')">supportId</label>
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
              <label class="form-control-label" v-text="$t('smarterCitySupportCenterApp.readSupportResponse.createDate')">createDate</label>
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
              <label class="form-control-label" v-text="$t('smarterCitySupportCenterApp.readSupportResponse.issue')">issue</label>
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
              <label class="form-control-label">Message History</label>
              <ul>
                <li v-for="(message, index) in taskContext.supportProcess.support.messageList" :key="index">{{ message.value }}</li>
              </ul>
            </div>

            <div class="form-group">
              <label class="form-control-label" v-text="$t('smarterCitySupportCenterApp.readSupportResponse.userReply')">userReply</label>
              <input
                readonly
                type="text"
                class="form-control"
                name="userReply"
                id="support-userReply"
                data-cy="userReply"
                v-model="taskContext.supportProcess.support.userReply"
              />
            </div>
            <div class="form-group">
              <label class="form-control-label" v-text="$t('smarterCitySupportCenterApp.readSupportResponse.isResolved')">isResolved</label>
              <input
                readonly
                type="text"
                class="form-control"
                name="isResolved"
                id="support-isResolved"
                data-cy="isResolved"
                v-model="taskContext.supportProcess.support.isResolved"
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
          :to="`/process-definition/SupportProcess/task/ReadSupportResponse/${taskContext.taskInstance.id}/execute`"
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

<script lang="ts" src="./read-support-response-details.component.ts"></script>
