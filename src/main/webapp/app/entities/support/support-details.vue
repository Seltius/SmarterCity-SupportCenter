<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <div v-if="support">
        <h2 class="jh-entity-heading" data-cy="supportDetailsHeading">
          <span v-text="$t('smarterCitySupportCenterApp.support.detail.title')">Support</span> {{ support.id }}
        </h2>
        <dl class="row jh-entity-details">
          <dt>
            <span v-text="$t('smarterCitySupportCenterApp.support.supportId')">Support Id</span>
          </dt>
          <dd>
            <span>{{ support.supportId }}</span>
          </dd>
          <dt>
            <span v-text="$t('smarterCitySupportCenterApp.support.startDate')">Start Date</span>
          </dt>
          <dd>
            <span>{{ support.startDate }}</span>
          </dd>
          <dt>
            <span v-text="$t('smarterCitySupportCenterApp.support.endDate')">End Date</span>
          </dt>
          <dd>
            <span>{{ support.endDate }}</span>
          </dd>
          <dt>
            <span v-text="$t('smarterCitySupportCenterApp.support.userName')">User Name</span>
          </dt>
          <dd>
            <span>{{ support.userName }}</span>
          </dd>
          <dt>
            <span v-text="$t('smarterCitySupportCenterApp.support.email')">Email</span>
          </dt>
          <dd>
            <span>{{ support.email }}</span>
          </dd>
          <dt>
            <span v-text="$t('smarterCitySupportCenterApp.support.message')">Message</span>
          </dt>
          <dd>
            <span>{{ support.message }}</span>
          </dd>
          <dt>
            <span v-text="$t('smarterCitySupportCenterApp.support.isRefund')">Is Refund</span>
          </dt>
          <dd>
            <span>{{ support.isRefund }}</span>
          </dd>
          <dt>
            <span v-text="$t('smarterCitySupportCenterApp.support.isValid')">Is Valid</span>
          </dt>
          <dd>
            <span>{{ support.isValid }}</span>
          </dd>
          <dt>
            <span v-text="$t('smarterCitySupportCenterApp.support.refundId')">Refund Id</span>
          </dt>
          <dd>
            <span>{{ support.refundId }}</span>
          </dd>
          <dt>
            <span v-text="$t('smarterCitySupportCenterApp.support.isResolved')">Is Resolved</span>
          </dt>
          <dd>
            <span>{{ support.isResolved }}</span>
          </dd>
          <dt>
            <span v-text="$t('smarterCitySupportCenterApp.support.status')">Status</span>
          </dt>
          <dd>
            <span>{{ support.status }}</span>
          </dd>
          <dt>
            <span v-text="$t('smarterCitySupportCenterApp.support.supportMessage')">Support Message</span>
          </dt>
          <dd>
            <span>{{ support.supportMessage }}</span>
          </dd>
        </dl>
        <button type="submit" v-on:click.prevent="previousState()" class="btn btn-info" data-cy="entityDetailsBackButton">
          <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.back')"> Back</span>
        </button>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./support-details.component.ts"></script>
