<template>
  <div>
    <h2 id="page-heading" data-cy="SupportHeading">
      <span v-text="$t('smarterCitySupportCenterApp.support.home.title')" id="support-heading">Supports</span>
      <div class="d-flex justify-content-end">
        <button class="btn btn-info mr-2" v-on:click="handleSyncList" :disabled="isFetching">
          <font-awesome-icon icon="sync" :spin="isFetching"></font-awesome-icon>
          <span v-text="$t('smarterCitySupportCenterApp.support.home.refreshListLabel')">Refresh List</span>
        </button>
      </div>
    </h2>
    <br />
    <div class="alert alert-warning" v-if="!isFetching && supports && supports.length === 0">
      <span v-text="$t('smarterCitySupportCenterApp.support.home.notFound')">No supports found</span>
    </div>
    <div class="table-responsive" v-if="supports && supports.length > 0">
      <table class="table table-striped" aria-describedby="supports">
        <thead>
          <tr>
            <th scope="row"><span v-text="$t('global.field.id')">ID</span></th>
            <th scope="row"><span v-text="$t('smarterCitySupportCenterApp.support.supportId')">Support Id</span></th>
            <th scope="row"><span v-text="$t('smarterCitySupportCenterApp.support.createDate')">Create Date</span></th>
            <th scope="row"><span v-text="$t('smarterCitySupportCenterApp.support.endDate')">End Date</span></th>
            <th scope="row"><span v-text="$t('smarterCitySupportCenterApp.support.name')">Name</span></th>
            <th scope="row"><span v-text="$t('smarterCitySupportCenterApp.support.email')">Email</span></th>
            <th scope="row"><span v-text="$t('smarterCitySupportCenterApp.support.issue')">Issue</span></th>
            <th scope="row"><span v-text="$t('smarterCitySupportCenterApp.support.isRefund')">Is Refund</span></th>
            <th scope="row"><span v-text="$t('smarterCitySupportCenterApp.support.isValid')">Is Valid</span></th>
            <th scope="row"><span v-text="$t('smarterCitySupportCenterApp.support.refundId')">Refund Id</span></th>
            <th scope="row"><span v-text="$t('smarterCitySupportCenterApp.support.isResolved')">Is Resolved</span></th>
            <th scope="row"><span v-text="$t('smarterCitySupportCenterApp.support.status')">Status</span></th>
            <th scope="row"><span v-text="$t('smarterCitySupportCenterApp.support.userReply')">User Reply</span></th>
            <th scope="row"><span v-text="$t('smarterCitySupportCenterApp.support.supportReply')">Support Reply</span></th>
            <th scope="row"></th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="support in supports" :key="support.id" data-cy="entityTable">
            <td>
              <router-link :to="{ name: 'SupportView', params: { supportId: support.id } }">{{ support.id }}</router-link>
            </td>
            <td>{{ support.supportId }}</td>
            <td>{{ support.createDate }}</td>
            <td>{{ support.endDate }}</td>
            <td>{{ support.name }}</td>
            <td>{{ support.email }}</td>
            <td>{{ support.issue }}</td>
            <td>{{ support.isRefund }}</td>
            <td>{{ support.isValid }}</td>
            <td>{{ support.refundId }}</td>
            <td>{{ support.isResolved }}</td>
            <td>{{ support.status }}</td>
            <td>{{ support.userReply }}</td>
            <td>{{ support.supportReply }}</td>
            <td class="text-right">
              <div class="btn-group">
                <router-link :to="{ name: 'SupportView', params: { supportId: support.id } }" custom v-slot="{ navigate }">
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
          id="smarterCitySupportCenterApp.support.delete.question"
          data-cy="supportDeleteDialogHeading"
          v-text="$t('entity.delete.title')"
          >Confirm delete operation</span
        ></span
      >
      <div class="modal-body">
        <p id="jhi-delete-support-heading" v-text="$t('smarterCitySupportCenterApp.support.delete.question', { id: removeId })">
          Are you sure you want to delete this Support?
        </p>
      </div>
      <div slot="modal-footer">
        <button type="button" class="btn btn-secondary" v-text="$t('entity.action.cancel')" v-on:click="closeDialog()">Cancel</button>
        <button
          type="button"
          class="btn btn-primary"
          id="jhi-confirm-delete-support"
          data-cy="entityConfirmDeleteButton"
          v-text="$t('entity.action.delete')"
          v-on:click="removeSupport()"
        >
          Delete
        </button>
      </div>
    </b-modal>
  </div>
</template>

<script lang="ts" src="./support.component.ts"></script>
