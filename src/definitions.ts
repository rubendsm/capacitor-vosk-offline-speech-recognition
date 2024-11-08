import type { PluginListenerHandle } from '@capacitor/core';

export interface VoskPlugin {
  //echo(options: { value: string }): Promise<{ value: string }>;
  //initModel(): Promise<void>; Now the model initiates on plugin load
  startListening(): Promise<void>;
  stopListening(): Promise<void>;
  pauseListening(): Promise<void>;
  resumeListening(): Promise<void>;
  isListening(): Promise<{ isListening: boolean }>;
  requestMicrophonePermission(): Promise<void>;  

  // Eventos para escutar transcrições parciais e finais
  addListener(
    eventName: 'partialResult',
    listener: (data: { matches: string }) => void
  ): Promise<PluginListenerHandle>;

    /* its Called after stream end so thats not interesting, i want the result after user stops talking
  addListener(
    eventName: 'finalResult',
    listener: (data: { result: string }) => void
  ): Promise<PluginListenerHandle>; */

  addListener(
    eventName: 'onResult',
    listener: (data: { final: string }) => void
  ): Promise<PluginListenerHandle>;
}
