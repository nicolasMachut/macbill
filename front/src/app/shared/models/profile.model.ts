import {Address} from './address.model';

export class Profile {
  id?: string;
  address: Address;
  siret: string;
  tvaIntracom: string;
  owner: string;
  iban: string;
  bic: string;
}