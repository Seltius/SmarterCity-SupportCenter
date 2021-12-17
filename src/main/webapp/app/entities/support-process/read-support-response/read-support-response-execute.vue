<template>
  <div class="row justify-content-center">
    <div class="col-10">
      <div v-if="taskContext.taskInstance">
        <h2 id="page-heading" data-cy="TaskInstanceHeading">
          <span v-text="$t('smarterCitySupportCenterApp.taskInstance.execute.title')" id="task-instance-heading">Task Execution</span>
        </h2>
        <akip-show-task-instance :taskInstance="taskContext.taskInstance">
          <template v-slot:body>
            <hr />
            <div class="form-group">
              <label
                class="form-control-label"
                v-text="$t('smarterCitySupportCenterApp.readSupportResponse.supportId')"
                for="read-support-response-supportId"
                >Support Id</label
              >
              <input
                type="number"
                class="form-control"
                name="supportId"
                id="read-support-response-supportId"
                readonly
                data-cy="supportId"
                :class="{
                  valid: !$v.taskContext.supportProcess.support.supportId.$invalid,
                  invalid: $v.taskContext.supportProcess.support.supportId.$invalid,
                }"
                v-model.number="$v.taskContext.supportProcess.support.supportId.$model"
              />
            </div>
            <div class="form-group">
              <label
                class="form-control-label"
                v-text="$t('smarterCitySupportCenterApp.readSupportResponse.createDate')"
                for="read-support-response-createDate"
                >Create Date</label
              >
              <b-input-group class="mb-3">
                <b-form-input
                  id="read-support-response-createDate"
                  readonly
                  data-cy="createDate"
                  type="text"
                  class="form-control"
                  name="createDate"
                  :class="{
                    valid: !$v.taskContext.supportProcess.support.createDate.$invalid,
                    invalid: $v.taskContext.supportProcess.support.createDate.$invalid,
                  }"
                  v-model="$v.taskContext.supportProcess.support.createDate.$model"
                />
              </b-input-group>
            </div>
            <div class="form-group">
              <label
                class="form-control-label"
                v-text="$t('smarterCitySupportCenterApp.readSupportResponse.issue')"
                for="read-support-response-issue"
                >Issue</label
              >
              <input
                type="text"
                class="form-control"
                name="issue"
                id="read-support-response-issue"
                readonly
                data-cy="issue"
                :class="{
                  valid: !$v.taskContext.supportProcess.support.issue.$invalid,
                  invalid: $v.taskContext.supportProcess.support.issue.$invalid,
                }"
                v-model="$v.taskContext.supportProcess.support.issue.$model"
              />
            </div>

            <div class="form-group">
              <label class="form-control-label">Message History</label>
              <ul style="list-style-type: none">
                <li v-for="(message, index) in taskContext.supportProcess.support.messageList" :key="index">
                  <p style="margin: 0" v-if="message.messageType === 'SUPPORT'">
                    <b>[{{ message.date }}] Support:</b> {{ message.value }}
                  </p>
                  <p style="margin: 0" v-if="message.messageType === 'REQUESTER'">
                    <b>[{{ message.date }}] Requester:</b> {{ message.value }}
                  </p>
                </li>
              </ul>
            </div>

            <div class="form-group">
              <label
                class="form-control-label"
                v-text="$t('smarterCitySupportCenterApp.readSupportResponse.userReply')"
                for="read-support-response-userReply"
                >User Reply</label
              >
              <input
                type="text"
                class="form-control"
                name="userReply"
                id="read-support-response-userReply"
                data-cy="userReply"
                :class="{
                  valid: !$v.taskContext.supportProcess.support.userReply.$invalid,
                  invalid: $v.taskContext.supportProcess.support.userReply.$invalid,
                }"
                v-model="$v.taskContext.supportProcess.support.userReply.$model"
              />
            </div>
            <div class="form-group">
              <label
                class="form-control-label"
                v-text="$t('smarterCitySupportCenterApp.readSupportResponse.isResolved')"
                for="read-support-response-isResolved"
                >Is Resolved</label
              >
              <input
                type="checkbox"
                class="form-check"
                name="isResolved"
                id="read-support-response-isResolved"
                data-cy="isResolved"
                :class="{
                  valid: !$v.taskContext.supportProcess.support.isResolved.$invalid,
                  invalid: $v.taskContext.supportProcess.support.isResolved.$invalid,
                }"
                v-model="$v.taskContext.supportProcess.support.isResolved.$model"
              />
            </div>
          </template>
        </akip-show-task-instance>
        <br />
        <button type="submit" v-on:click.prevent="previousState()" class="btn btn-info" data-cy="entityDetailsBackButton">
          <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.back')"> Back</span>
        </button>
        <button type="submit" v-on:click.prevent="complete()" class="btn btn-success" data-cy="complete">
          <font-awesome-icon icon="check-circle"></font-awesome-icon>&nbsp;Complete
        </button>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./read-support-response-execute.component.ts"></script>
