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
              <label class="form-control-label" v-text="$t('smarterCitySupportCenterApp.readSupportResponse.startDate')">startDate</label>
              <input
                readonly
                type="text"
                class="form-control"
                name="startDate"
                id="support-startDate"
                data-cy="startDate"
                v-model="taskContext.supportProcess.support.startDate"
              />
            </div>
            <div class="form-group">
              <label class="form-control-label" v-text="$t('smarterCitySupportCenterApp.readSupportResponse.userName')">userName</label>
              <input
                readonly
                type="text"
                class="form-control"
                name="userName"
                id="support-userName"
                data-cy="userName"
                v-model="taskContext.supportProcess.support.userName"
              />
            </div>
            <div class="form-group">
              <label class="form-control-label" v-text="$t('smarterCitySupportCenterApp.readSupportResponse.email')">email</label>
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
              <label class="form-control-label" v-text="$t('smarterCitySupportCenterApp.readSupportResponse.message')">message</label>
              <input
                readonly
                type="text"
                class="form-control"
                name="message"
                id="support-message"
                data-cy="message"
                v-model="taskContext.supportProcess.support.message"
              />
            </div>
            <div class="form-group">
              <label class="form-control-label" v-text="$t('smarterCitySupportCenterApp.readSupportResponse.supportMessage')"
                >supportMessage</label
              >
              <input
                readonly
                type="text"
                class="form-control"
                name="supportMessage"
                id="support-supportMessage"
                data-cy="supportMessage"
                v-model="taskContext.supportProcess.support.supportMessage"
              />
            </div>

            <div class="form-group">
              <label class="form-control-label">Message History</label>
              <ul>
                <li v-for="(message, index) in taskContext.supportProcess.support" :key="index">{{ message }}</li>
              </ul>
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
