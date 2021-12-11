<template>
  <div>
    <h2 id="page-heading" data-cy="RefundHeading">
      <span v-text="$t('smarterCitySupportCenterApp.refund.home.title')" id="refund-heading">Refunds</span>
      <div class="d-flex justify-content-end">
        <button class="btn btn-info mr-2" v-on:click="handleSyncList" :disabled="isFetching">
          <font-awesome-icon icon="sync" :spin="isFetching"></font-awesome-icon>
          <span v-text="$t('smarterCitySupportCenterApp.refund.home.refreshListLabel')">Refresh List</span>
        </button>
      </div>
    </h2>
    <br />
    <div class="alert alert-warning" v-if="!isFetching && refunds && refunds.length === 0">
      <span v-text="$t('smarterCitySupportCenterApp.refund.home.notFound')">No refunds found</span>
    </div>
    <div class="table-responsive" v-if="refunds && refunds.length > 0">
      <table class="table table-striped" aria-describedby="refunds">
        <thead>
          <tr>
            <th scope="row"><span v-text="$t('global.field.id')">ID</span></th>
            <th scope="row"><span v-text="$t('smarterCitySupportCenterApp.refund.refundId')">Refund Id</span></th>
            <th scope="row"><span v-text="$t('smarterCitySupportCenterApp.refund.amount')">Amount</span></th>
            <th scope="row"><span v-text="$t('smarterCitySupportCenterApp.refund.method')">Method</span></th>
            <th scope="row"></th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="refund in refunds" :key="refund.id" data-cy="entityTable">
            <td>
              <router-link :to="{ name: 'RefundView', params: { refundId: refund.id } }">{{ refund.id }}</router-link>
            </td>
            <td>{{ refund.refundId }}</td>
            <td>{{ refund.amount }}</td>
            <td>{{ refund.method }}</td>
            <td class="text-right">
              <div class="btn-group">
                <router-link :to="{ name: 'RefundView', params: { refundId: refund.id } }" custom v-slot="{ navigate }">
                  <button @click="navigate" class="btn btn-info btn-sm details" data-cy="entityDetailsButton">
                    <font-awesome-icon icon="eye"></font-awesome-icon>
                    <span class="d-none d-md-inline" v-text="$t('entity.action.view')">View</span>
                  </button>
                </router-link>
              </div>
            </td>
          </tr>
        </tbody>
      </table>
    </div>
    <b-modal ref="removeEntity" id="removeEntity">
      <span slot="modal-title"
        ><span
          id="smarterCitySupportCenterApp.refund.delete.question"
          data-cy="refundDeleteDialogHeading"
          v-text="$t('entity.delete.title')"
          >Confirm delete operation</span
        ></span
      >
      <div class="modal-body">
        <p id="jhi-delete-refund-heading" v-text="$t('smarterCitySupportCenterApp.refund.delete.question', { id: removeId })">
          Are you sure you want to delete this Refund?
        </p>
      </div>
      <div slot="modal-footer">
        <button type="button" class="btn btn-secondary" v-text="$t('entity.action.cancel')" v-on:click="closeDialog()">Cancel</button>
        <button
          type="button"
          class="btn btn-primary"
          id="jhi-confirm-delete-refund"
          data-cy="entityConfirmDeleteButton"
          v-text="$t('entity.action.delete')"
          v-on:click="removeRefund()"
        >
          Delete
        </button>
      </div>
    </b-modal>
  </div>
</template>

<script lang="ts" src="./refund.component.ts"></script>
