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
                v-text="$t('smarterCitySupportCenterApp.provideSupportResponse.startDate')"
                for="provide-support-response-startDate"
                >Start Date</label
              >
              <b-input-group class="mb-3">
                <b-form-input
                  id="provide-support-response-startDate"
                  readonly
                  data-cy="startDate"
                  type="text"
                  class="form-control"
                  name="startDate"
                  :class="{
                    valid: !$v.taskContext.supportProcess.support.startDate.$invalid,
                    invalid: $v.taskContext.supportProcess.support.startDate.$invalid,
                  }"
                  v-model="$v.taskContext.supportProcess.support.startDate.$model"
                />
              </b-input-group>
            </div>
            <div class="form-group">
              <label
                class="form-control-label"
                v-text="$t('smarterCitySupportCenterApp.provideSupportResponse.userName')"
                for="provide-support-response-userName"
                >User Name</label
              >
              <input
                type="text"
                class="form-control"
                name="userName"
                id="provide-support-response-userName"
                readonly
                data-cy="userName"
                :class="{
                  valid: !$v.taskContext.supportProcess.support.userName.$invalid,
                  invalid: $v.taskContext.supportProcess.support.userName.$invalid,
                }"
                v-model="$v.taskContext.supportProcess.support.userName.$model"
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
                v-text="$t('smarterCitySupportCenterApp.provideSupportResponse.message')"
                for="provide-support-response-message"
                >Message</label
              >
              <input
                type="text"
                class="form-control"
                name="message"
                id="provide-support-response-message"
                readonly
                data-cy="message"
                :class="{
                  valid: !$v.taskContext.supportProcess.support.message.$invalid,
                  invalid: $v.taskContext.supportProcess.support.message.$invalid,
                }"
                v-model="$v.taskContext.supportProcess.support.message.$model"
              />
            </div>
            <div class="form-group">
              <label
                class="form-control-label"
                v-text="$t('smarterCitySupportCenterApp.provideSupportResponse.supportMessage')"
                for="provide-support-response-supportMessage"
                >Support Message</label
              >
              <input
                type="text"
                class="form-control"
                name="supportMessage"
                id="provide-support-response-supportMessage"
                data-cy="supportMessage"
                :class="{
                  valid: !$v.taskContext.supportProcess.support.supportMessage.$invalid,
                  invalid: $v.taskContext.supportProcess.support.supportMessage.$invalid,
                }"
                v-model="$v.taskContext.supportProcess.support.supportMessage.$model"
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
