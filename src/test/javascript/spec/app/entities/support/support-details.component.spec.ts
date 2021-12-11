/* tslint:disable max-line-length */
import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';
import VueRouter from 'vue-router';

import * as config from '@/shared/config/config';
import SupportDetailComponent from '@/entities/support/support-details.vue';
import SupportClass from '@/entities/support/support-details.component';
import SupportService from '@/entities/support/support.service';
import router from '@/router';

const localVue = createLocalVue();
localVue.use(VueRouter);

config.initVueApp(localVue);
const i18n = config.initI18N(localVue);
const store = config.initVueXStore(localVue);
localVue.component('font-awesome-icon', {});
localVue.component('router-link', {});

describe('Component Tests', () => {
  describe('Support Management Detail Component', () => {
    let wrapper: Wrapper<SupportClass>;
    let comp: SupportClass;
    let supportServiceStub: SinonStubbedInstance<SupportService>;

    beforeEach(() => {
      supportServiceStub = sinon.createStubInstance<SupportService>(SupportService);

      wrapper = shallowMount<SupportClass>(SupportDetailComponent, {
        store,
        i18n,
        localVue,
        router,
        provide: { supportService: () => supportServiceStub },
      });
      comp = wrapper.vm;
    });

    describe('OnInit', () => {
      it('Should call load all on init', async () => {
        // GIVEN
        const foundSupport = { id: 123 };
        supportServiceStub.find.resolves(foundSupport);

        // WHEN
        comp.retrieveSupport(123);
        await comp.$nextTick();

        // THEN
        expect(comp.support).toBe(foundSupport);
      });
    });

    describe('Before route enter', () => {
      it('Should retrieve data', async () => {
        // GIVEN
        const foundSupport = { id: 123 };
        supportServiceStub.find.resolves(foundSupport);

        // WHEN
        comp.beforeRouteEnter({ params: { supportId: 123 } }, null, cb => cb(comp));
        await comp.$nextTick();

        // THEN
        expect(comp.support).toBe(foundSupport);
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
