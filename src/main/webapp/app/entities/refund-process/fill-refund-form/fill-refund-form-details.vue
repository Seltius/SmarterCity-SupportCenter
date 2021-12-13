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
              <label class="form-control-label" v-text="$t('smarterCitySupportCenterApp.fillRefundForm.amount')">amount</label>
              <input
                readonly
                type="text"
                class="form-control"
                name="amount"
                id="refund-amount"
                data-cy="amount"
                v-model="taskContext.refundProcess.refund.amount"
              />
            </div>
            <div class="form-group">
              <label class="form-control-label" v-text="$t('smarterCitySupportCenterApp.fillRefundForm.method')">method</label>
              <input
                readonly
                type="text"
                class="form-control"
                name="method"
                id="refund-method"
                data-cy="method"
                v-model="taskContext.refundProcess.refund.method"
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
          :to="`/process-definition/SupportProcess/task/FillRefundForm/${taskContext.taskInstance.id}/execute`"
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

<script lang="ts" src="./fill-refund-form-details.component.ts"></script>
