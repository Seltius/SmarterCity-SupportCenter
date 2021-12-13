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
                v-text="$t('smarterCitySupportCenterApp.fillRefundForm.amount')"
                for="fill-refund-form-amount"
                >Amount</label
              >
              <input
                type="number"
                class="form-control"
                name="amount"
                id="fill-refund-form-amount"
                data-cy="amount"
                :class="{
                  valid: !$v.taskContext.refundProcess.refund.amount.$invalid,
                  invalid: $v.taskContext.refundProcess.refund.amount.$invalid,
                }"
                v-model.number="$v.taskContext.refundProcess.refund.amount.$model"
              />
            </div>
            <div class="form-group">
              <label
                class="form-control-label"
                v-text="$t('smarterCitySupportCenterApp.fillRefundForm.method')"
                for="fill-refund-form-method"
                >Method</label
              >
              <input
                type="text"
                class="form-control"
                name="method"
                id="fill-refund-form-method"
                data-cy="method"
                :class="{
                  valid: !$v.taskContext.refundProcess.refund.method.$invalid,
                  invalid: $v.taskContext.refundProcess.refund.method.$invalid,
                }"
                v-model="$v.taskContext.refundProcess.refund.method.$model"
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

<script lang="ts" src="./fill-refund-form-execute.component.ts"></script>
