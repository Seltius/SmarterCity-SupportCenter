/* tslint:disable max-line-length */
import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';
import VueRouter from 'vue-router';

import * as config from '@/shared/config/config';
import RefundDetailComponent from '@/entities/refund/refund-details.vue';
import RefundClass from '@/entities/refund/refund-details.component';
import RefundService from '@/entities/refund/refund.service';
import router from '@/router';

const localVue = createLocalVue();
localVue.use(VueRouter);

config.initVueApp(localVue);
const i18n = config.initI18N(localVue);
const store = config.initVueXStore(localVue);
localVue.component('font-awesome-icon', {});
localVue.component('router-link', {});

describe('Component Tests', () => {
  describe('Refund Management Detail Component', () => {
    let wrapper: Wrapper<RefundClass>;
    let comp: RefundClass;
    let refundServiceStub: SinonStubbedInstance<RefundService>;

    beforeEach(() => {
      refundServiceStub = sinon.createStubInstance<RefundService>(RefundService);

      wrapper = shallowMount<RefundClass>(RefundDetailComponent, {
        store,
        i18n,
        localVue,
        router,
        provide: { refundService: () => refundServiceStub },
      });
      comp = wrapper.vm;
    });

    describe('OnInit', () => {
      it('Should call load all on init', async () => {
        // GIVEN
        const foundRefund = { id: 123 };
        refundServiceStub.find.resolves(foundRefund);

        // WHEN
        comp.retrieveRefund(123);
        await comp.$nextTick();

        // THEN
        expect(comp.refund).toBe(foundRefund);
      });
    });

    describe('Before route enter', () => {
      it('Should retrieve data', async () => {
        // GIVEN
        const foundRefund = { id: 123 };
        refundServiceStub.find.resolves(foundRefund);

        // WHEN
        comp.beforeRouteEnter({ params: { refundId: 123 } }, null, cb => cb(comp));
        await comp.$nextTick();

        // THEN
        expect(comp.refund).toBe(foundRefund);
      });
    });

    describe('Previous state', () => {
      it('Should go previous state', async () => {
        comp.previousState();
        await comp.$nextTick();

        expect(comp.$router.currentRoute.fullPath).toContain('/');
      });
    });
  });
});
