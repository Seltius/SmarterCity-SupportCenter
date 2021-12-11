<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <div v-if="refund">
        <h2 class="jh-entity-heading" data-cy="refundDetailsHeading">
          <span v-text="$t('smarterCitySupportCenterApp.refund.detail.title')">Refund</span> {{ refund.id }}
        </h2>
        <dl class="row jh-entity-details">
          <dt>
            <span v-text="$t('smarterCitySupportCenterApp.refund.refundId')">Refund Id</span>
          </dt>
          <dd>
            <span>{{ refund.refundId }}</span>
          </dd>
          <dt>
            <span v-text="$t('smarterCitySupportCenterApp.refund.amount')">Amount</span>
          </dt>
          <dd>
            <span>{{ refund.amount }}</span>
          </dd>
          <dt>
            <span v-text="$t('smarterCitySupportCenterApp.refund.method')">Method</span>
          </dt>
          <dd>
            <span>{{ refund.method }}</span>
          </dd>
        </dl>
        <button type="submit" v-on:click.prevent="previousState()" class="btn btn-info" data-cy="entityDetailsBackButton">
          <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.back')"> Back</span>
        </button>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./refund-details.component.ts"></script>
