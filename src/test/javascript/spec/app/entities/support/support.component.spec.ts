/* tslint:disable max-line-length */
import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';

import * as config from '@/shared/config/config';
import SupportComponent from '@/entities/support/support.vue';
import SupportClass from '@/entities/support/support.component';
import SupportService from '@/entities/support/support.service';

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
  describe('Support Management Component', () => {
    let wrapper: Wrapper<SupportClass>;
    let comp: SupportClass;
    let supportServiceStub: SinonStubbedInstance<SupportService>;

    beforeEach(() => {
      supportServiceStub = sinon.createStubInstance<SupportService>(SupportService);
      supportServiceStub.retrieve.resolves({ headers: {} });

      wrapper = shallowMount<SupportClass>(SupportComponent, {
        store,
        i18n,
        localVue,
        stubs: { bModal: bModalStub as any },
        provide: {
          supportService: () => supportServiceStub,
        },
      });
      comp = wrapper.vm;
    });

    it('Should call load all on init', async () => {
      // GIVEN
      supportServiceStub.retrieve.resolves({ headers: {}, data: [{ id: 123 }] });

      // WHEN
      comp.retrieveAllSupports();
      await comp.$nextTick();

      // THEN
      expect(supportServiceStub.retrieve.called).toBeTruthy();
      expect(comp.supports[0]).toEqual(jasmine.objectContaining({ id: 123 }));
    });
  });
});
