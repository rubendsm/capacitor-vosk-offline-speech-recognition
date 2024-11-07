import type { PluginListenerHandle } from '@capacitor/core';

export interface VoskPlugin {
  echo(options: { value: string }): Promise<{ value: string }>;
  initModel(): Promise<void>;
  startListening(): Promise<void>;
  stopListening(): Promise<void>;
  isListening(): Promise<{ listening: boolean }>;
  requestMicrophonePermission(): Promise<void>;  

  // Eventos para escutar transcrições parciais e finais
  addListener(
    eventName: 'partialResult',
    listener: (result: { partial: string }) => void
  ): Promise<PluginListenerHandle>;

  addListener(
    eventName: 'finalResult',
    listener: (result: { partial: string, final: string }) => void
  ): Promise<PluginListenerHandle>;

  addListener(
    eventName: 'onResult',
    listener: (result: { partial: string, final: string }) => void
  ): Promise<PluginListenerHandle>;
}
