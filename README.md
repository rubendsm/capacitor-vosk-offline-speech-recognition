# @capacitor-community/vosk

Offline speech recognition

## Install

```bash
npm install @capacitor-community/vosk
npx cap sync
```

## API

<docgen-index>

* [`echo(...)`](#echo)
* [`initModel()`](#initmodel)
* [`startListening()`](#startlistening)
* [`stopListening()`](#stoplistening)
* [`isListening()`](#islistening)
* [`requestMicrophonePermission()`](#requestmicrophonepermission)
* [`addListener('partialResult', ...)`](#addlistenerpartialresult-)
* [`addListener('finalResult', ...)`](#addlistenerfinalresult-)
* [`addListener('onResult', ...)`](#addlisteneronresult-)
* [Interfaces](#interfaces)

</docgen-index>

<docgen-api>
<!--Update the source file JSDoc comments and rerun docgen to update the docs below-->

### echo(...)

```typescript
echo(options: { value: string; }) => Promise<{ value: string; }>
```

| Param         | Type                            |
| ------------- | ------------------------------- |
| **`options`** | <code>{ value: string; }</code> |

**Returns:** <code>Promise&lt;{ value: string; }&gt;</code>

--------------------


### initModel()

```typescript
initModel() => Promise<void>
```

--------------------


### startListening()

```typescript
startListening() => Promise<void>
```

--------------------


### stopListening()

```typescript
stopListening() => Promise<void>
```

--------------------


### isListening()

```typescript
isListening() => Promise<{ listening: boolean; }>
```

**Returns:** <code>Promise&lt;{ listening: boolean; }&gt;</code>

--------------------


### requestMicrophonePermission()

```typescript
requestMicrophonePermission() => Promise<void>
```

--------------------


### addListener('partialResult', ...)

```typescript
addListener(eventName: 'partialResult', listener: (result: { partial: string; }) => void) => Promise<PluginListenerHandle>
```

| Param           | Type                                                   |
| --------------- | ------------------------------------------------------ |
| **`eventName`** | <code>'partialResult'</code>                           |
| **`listener`**  | <code>(result: { partial: string; }) =&gt; void</code> |

**Returns:** <code>Promise&lt;<a href="#pluginlistenerhandle">PluginListenerHandle</a>&gt;</code>

--------------------


### addListener('finalResult', ...)

```typescript
addListener(eventName: 'finalResult', listener: (result: { partial: string; final: string; }) => void) => Promise<PluginListenerHandle>
```

| Param           | Type                                                                  |
| --------------- | --------------------------------------------------------------------- |
| **`eventName`** | <code>'finalResult'</code>                                            |
| **`listener`**  | <code>(result: { partial: string; final: string; }) =&gt; void</code> |

**Returns:** <code>Promise&lt;<a href="#pluginlistenerhandle">PluginListenerHandle</a>&gt;</code>

--------------------


### addListener('onResult', ...)

```typescript
addListener(eventName: 'onResult', listener: (result: { partial: string; final: string; }) => void) => Promise<PluginListenerHandle>
```

| Param           | Type                                                                  |
| --------------- | --------------------------------------------------------------------- |
| **`eventName`** | <code>'onResult'</code>                                               |
| **`listener`**  | <code>(result: { partial: string; final: string; }) =&gt; void</code> |

**Returns:** <code>Promise&lt;<a href="#pluginlistenerhandle">PluginListenerHandle</a>&gt;</code>

--------------------


### Interfaces


#### PluginListenerHandle

| Prop         | Type                                      |
| ------------ | ----------------------------------------- |
| **`remove`** | <code>() =&gt; Promise&lt;void&gt;</code> |

</docgen-api>
