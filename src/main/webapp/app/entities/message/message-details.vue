<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <div v-if="message">
        <h2 class="jh-entity-heading" data-cy="messageDetailsHeading">
          <span v-text="$t('smarterCitySupportCenterApp.message.detail.title')">Message</span> {{ message.id }}
        </h2>
        <dl class="row jh-entity-details">
          <dt>
            <span v-text="$t('smarterCitySupportCenterApp.message.supportId')">Support Id</span>
          </dt>
          <dd>
            <span>{{ message.supportId }}</span>
          </dd>
          <dt>
            <span v-text="$t('smarterCitySupportCenterApp.message.date')">Date</span>
          </dt>
          <dd>
            <span>{{ message.date }}</span>
          </dd>
          <dt>
            <span v-text="$t('smarterCitySupportCenterApp.message.messageType')">Message Type</span>
          </dt>
          <dd>
            <span>{{ message.messageType }}</span>
          </dd>
          <dt>
            <span v-text="$t('smarterCitySupportCenterApp.message.value')">Value</span>
          </dt>
          <dd>
            <span>{{ message.value }}</span>
          </dd>
        </dl>
        <button type="submit" v-on:click.prevent="previousState()" class="btn btn-info" data-cy="entityDetailsBackButton">
          <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.back')"> Back</span>
        </button>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./message-details.component.ts"></script>
