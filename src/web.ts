import { WebPlugin } from '@capacitor/core';

import type { PermissionStatus, VoskPlugin } from './definitions';

export class VoskWeb extends WebPlugin implements VoskPlugin {
  requestPermissions(): Promise<PermissionStatus> {
    throw new Error('Method not implemented.');
  }
  available(): Promise<{ available: boolean; }> {
    throw new Error('Method not implemented.');
  }
  pauseListening(): Promise<void> {
    throw new Error('Method not implemented.');
  }
  resumeListening(): Promise<void> {
    throw new Error('Method not implemented.');
  }
  startListening(): Promise<void> {
    throw new Error('Method not implemented.');
  }
  stopListening(): Promise<void> {
    throw new Error('Method not implemented.');
  }
  isListening(): Promise<{ isListening: boolean; }> {
    throw new Error('Method not implemented.');
  }
 

}
