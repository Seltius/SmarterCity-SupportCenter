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
                v-text="$t('smarterCitySupportCenterApp.provideSupportResponse.supportId')"
                for="provide-support-response-supportId"
                >Support Id</label
              >
              <input
                type="number"
                class="form-control"
                name="supportId"
                id="provide-support-response-supportId"
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
                v-text="$t('smarterCitySupportCenterApp.provideSupportResponse.createDate')"
                for="provide-support-response-createDate"
                >Create Date</label
              >
              <b-input-group class="mb-3">
                <b-form-input
                  id="provide-support-response-createDate"
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
                v-text="$t('smarterCitySupportCenterApp.provideSupportResponse.name')"
                for="provide-support-response-name"
                >Name</label
              >
              <input
                type="text"
                class="form-control"
                name="name"
                id="provide-support-response-name"
                readonly
                data-cy="name"
                :class="{
                  valid: !$v.taskContext.supportProcess.support.name.$invalid,
                  invalid: $v.taskContext.supportProcess.support.name.$invalid,
                }"
                v-model="$v.taskContext.supportProcess.support.name.$model"
              />
            </div>
            <div class="form-group">
              <label
                class="form-control-label"
                v-text="$t('smarterCitySupportCenterApp.provideSupportResponse.email')"
                for="provide-support-response-email"
                >Email</label
              >
              <input
                type="text"
                class="form-control"
                name="email"
                id="provide-support-response-email"
                readonly
                data-cy="email"
                :class="{
                  valid: !$v.taskContext.supportProcess.support.email.$invalid,
                  invalid: $v.taskContext.supportProcess.support.email.$invalid,
                }"
                v-model="$v.taskContext.supportProcess.support.email.$model"
              />
            </div>
            <div class="form-group">
              <label
                class="form-control-label"
                v-text="$t('smarterCitySupportCenterApp.provideSupportResponse.issue')"
                for="provide-support-response-issue"
                >Issue</label
              >
              <input
                type="text"
                class="form-control"
                name="issue"
                id="provide-support-response-issue"
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
              <label
                class="form-control-label"
                v-text="$t('smarterCitySupportCenterApp.provideSupportResponse.supportReply')"
                for="provide-support-response-supportReply"
                >Support Reply</label
              >
              <input
                type="text"
                class="form-control"
                name="supportReply"
                id="provide-support-response-supportReply"
                data-cy="supportReply"
                :class="{
                  valid: !$v.taskContext.supportProcess.support.supportReply.$invalid,
                  invalid: $v.taskContext.supportProcess.support.supportReply.$invalid,
                }"
                v-model="$v.taskContext.supportProcess.support.supportReply.$model"
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

<script lang="ts" src="./provide-support-response-execute.component.ts"></script>
