/* tslint:disable max-line-length */
import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';

import * as config from '@/shared/config/config';
import RefundComponent from '@/entities/refund/refund.vue';
import RefundClass from '@/entities/refund/refund.component';
import RefundService from '@/entities/refund/refund.service';

const localVue = createLocalVue();

config.initVueApp(localVue);
const i18n = config.initI18N(localVue);
const store = config.initVueXStore(localVue);
localVue.component('font-awesome-icon', {});
localVue.component('b-badge', {});
localVue.directive('b-modal', {});
localVue.component('b-button', {});
localVue.component('router-link', {});

const bModalStub = {
  render: () => {},
  methods: {
    hide: () => {},
    show: () => {},
  },
};

describe('Component Tests', () => {
  describe('Refund Management Component', () => {
    let wrapper: Wrapper<RefundClass>;
    let comp: RefundClass;
    let refundServiceStub: SinonStubbedInstance<RefundService>;

    beforeEach(() => {
      refundServiceStub = sinon.createStubInstance<RefundService>(RefundService);
      refundServiceStub.retrieve.resolves({ headers: {} });

      wrapper = shallowMount<RefundClass>(RefundComponent, {
        store,
        i18n,
        localVue,
        stubs: { bModal: bModalStub as any },
        provide: {
          refundService: () => refundServiceStub,
        },
      });
      comp = wrapper.vm;
    });

    it('Should call load all on init', async () => {
      // GIVEN
      refundServiceStub.retrieve.resolves({ headers: {}, data: [{ id: 123 }] });

      // WHEN
      comp.retrieveAllRefunds();
      await comp.$nextTick();

      // THEN
      expect(refundServiceStub.retrieve.called).toBeTruthy();
      expect(comp.refunds[0]).toEqual(jasmine.objectContaining({ id: 123 }));
    });
  });
});
