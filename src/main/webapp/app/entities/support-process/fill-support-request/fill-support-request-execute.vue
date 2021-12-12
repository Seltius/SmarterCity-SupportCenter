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
                v-text="$t('smarterCitySupportCenterApp.fillSupportRequest.name')"
                for="fill-support-request-name"
                >Name</label
              >
              <input
                type="text"
                class="form-control"
                name="name"
                id="fill-support-request-name"
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
                v-text="$t('smarterCitySupportCenterApp.fillSupportRequest.email')"
                for="fill-support-request-email"
                >Email</label
              >
              <input
                type="text"
                class="form-control"
                name="email"
                id="fill-support-request-email"
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
                v-text="$t('smarterCitySupportCenterApp.fillSupportRequest.issue')"
                for="fill-support-request-issue"
                >Issue</label
              >
              <input
                type="text"
                class="form-control"
                name="issue"
                id="fill-support-request-issue"
                data-cy="issue"
                :class="{
                  valid: !$v.taskContext.supportProcess.support.issue.$invalid,
                  invalid: $v.taskContext.supportProcess.support.issue.$invalid,
                }"
                v-model="$v.taskContext.supportProcess.support.issue.$model"
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

<script lang="ts" src="./fill-support-request-execute.component.ts"></script>
