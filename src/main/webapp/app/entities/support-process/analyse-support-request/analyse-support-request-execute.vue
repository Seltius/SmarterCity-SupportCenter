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
                v-text="$t('smarterCitySupportCenterApp.analyseSupportRequest.supportId')"
                for="analyse-support-request-supportId"
                >Support Id</label
              >
              <input
                type="number"
                class="form-control"
                name="supportId"
                id="analyse-support-request-supportId"
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
                v-text="$t('smarterCitySupportCenterApp.analyseSupportRequest.startDate')"
                for="analyse-support-request-startDate"
                >Start Date</label
              >
              <b-input-group class="mb-3">
                <b-form-input
                  id="analyse-support-request-startDate"
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
                v-text="$t('smarterCitySupportCenterApp.analyseSupportRequest.userName')"
                for="analyse-support-request-userName"
                >User Name</label
              >
              <input
                type="text"
                class="form-control"
                name="userName"
                id="analyse-support-request-userName"
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
                v-text="$t('smarterCitySupportCenterApp.analyseSupportRequest.email')"
                for="analyse-support-request-email"
                >Email</label
              >
              <input
                type="text"
                class="form-control"
                name="email"
                id="analyse-support-request-email"
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
                v-text="$t('smarterCitySupportCenterApp.analyseSupportRequest.message')"
                for="analyse-support-request-message"
                >Message</label
              >
              <input
                type="text"
                class="form-control"
                name="message"
                id="analyse-support-request-message"
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
                v-text="$t('smarterCitySupportCenterApp.analyseSupportRequest.isRefund')"
                for="analyse-support-request-isRefund"
                >Is Refund</label
              >
              <input
                type="checkbox"
                class="form-check"
                name="isRefund"
                id="analyse-support-request-isRefund"
                data-cy="isRefund"
                :class="{
                  valid: !$v.taskContext.supportProcess.support.isRefund.$invalid,
                  invalid: $v.taskContext.supportProcess.support.isRefund.$invalid,
                }"
                v-model="$v.taskContext.supportProcess.support.isRefund.$model"
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

<script lang="ts" src="./analyse-support-request-execute.component.ts"></script>
