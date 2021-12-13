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
                v-text="$t('smarterCitySupportCenterApp.analyseRefundRequest.supportId')"
                for="analyse-refund-request-supportId"
                >Support Id</label
              >
              <input
                type="number"
                class="form-control"
                name="supportId"
                id="analyse-refund-request-supportId"
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
                v-text="$t('smarterCitySupportCenterApp.analyseRefundRequest.createDate')"
                for="analyse-refund-request-createDate"
                >Create Date</label
              >
              <b-input-group class="mb-3">
                <b-form-input
                  id="analyse-refund-request-createDate"
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
                v-text="$t('smarterCitySupportCenterApp.analyseRefundRequest.name')"
                for="analyse-refund-request-name"
                >Name</label
              >
              <input
                type="text"
                class="form-control"
                name="name"
                id="analyse-refund-request-name"
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
                v-text="$t('smarterCitySupportCenterApp.analyseRefundRequest.email')"
                for="analyse-refund-request-email"
                >Email</label
              >
              <input
                type="text"
                class="form-control"
                name="email"
                id="analyse-refund-request-email"
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
                v-text="$t('smarterCitySupportCenterApp.analyseRefundRequest.issue')"
                for="analyse-refund-request-issue"
                >Issue</label
              >
              <input
                type="text"
                class="form-control"
                name="issue"
                id="analyse-refund-request-issue"
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
                v-text="$t('smarterCitySupportCenterApp.analyseRefundRequest.isValid')"
                for="analyse-refund-request-isValid"
                >Is Valid</label
              >
              <input
                type="checkbox"
                class="form-check"
                name="isValid"
                id="analyse-refund-request-isValid"
                data-cy="isValid"
                :class="{
                  valid: !$v.taskContext.supportProcess.support.isValid.$invalid,
                  invalid: $v.taskContext.supportProcess.support.isValid.$invalid,
                }"
                v-model="$v.taskContext.supportProcess.support.isValid.$model"
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

<script lang="ts" src="./analyse-refund-request-execute.component.ts"></script>
