<template>
  <div class="row justify-content-center">
    <div class="col-10">
      <form name="editForm" role="form" novalidate v-on:submit.prevent="save()">
        <h2
          id="smarterCitySupportCenterApp.supportStartForm.home.createOrEditLabel"
          data-cy="SupportStartFormCreateUpdateHeading"
          v-text="$t('smarterCitySupportCenterApp.supportStartForm.home.createOrEditLabel')"
        >
          Create or edit a SupportStartForm
        </h2>
        <div v-if="supportProcess.processInstance">
          <akip-show-process-definition :processDefinition="supportProcess.processInstance.processDefinition">
            <template v-slot:body>
              <hr />
              <div v-if="supportProcess.support"></div>
            </template>
          </akip-show-process-definition>
          <br />
          <button type="button" id="cancel-save" class="btn btn-secondary" v-on:click="previousState()">
            <font-awesome-icon icon="ban"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.cancel')">Cancel</span>
          </button>
          <button
            type="submit"
            id="save-entity"
            data-cy="entityCreateSaveButton"
            :disabled="$v.supportProcess.$invalid || isSaving"
            class="btn btn-primary"
          >
            <font-awesome-icon icon="play"></font-awesome-icon>&nbsp;<span>Start</span>
          </button>
        </div>
      </form>
    </div>
  </div>
</template>
<script lang="ts" src="./support-start-form-init.component.ts"></script>
