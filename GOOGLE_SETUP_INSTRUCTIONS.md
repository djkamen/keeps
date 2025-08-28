# Настройка Google Console для Google Sign-In

## Необходимые шаги:

### 1. Перейти в Google Cloud Console
- Откройте https://console.cloud.google.com/
- Выберите проект "notes-app-collaboration" (или создайте новый)

### 2. Включить API
- Перейдите в "APIs & Services" > "Library"
- Найдите и включите:
  - Google Drive API
  - Google Sign-In API (Google+ API)

### 3. Настроить OAuth 2.0
- Перейдите в "APIs & Services" > "Credentials"
- Нажмите "Create Credentials" > "OAuth 2.0 Client IDs"
- Выберите "Android application"

### 4. Добавить данные приложения
- Package name: `com.notesapp`
- SHA-1 certificate fingerprint: `A7:D8:E9:C8:51:E4:B1:FE:C7:BB:F7:5A:E5:E2:CD:55:01:C7:CB:2B`

### 5. Настроить Google Drive
- В разделе "APIs & Services" > "Google Drive API"
- Убедитесь, что API включено
- Проверьте квоты (для тестирования достаточно стандартных)

### 6. Настроить разрешения для папки
- Откройте папку Google Drive: https://drive.google.com/drive/folders/1KzLFmGOmBIuisUA4F4oqcoAo22AVQRsU
- Нажмите "Поделиться"
- Добавьте email аккаунта, который будет использоваться в приложении
- Дайте права "Редактор" или "Владелец"

### 7. Скачать обновленный google-services.json
- После настройки OAuth в Google Console
- Скачайте новый google-services.json
- Замените файл в app/google-services.json

## Проверка настройки:
1. Соберите APK: `.\gradlew.bat assembleDebug`
2. Установите на телефон
3. При запуске выберите "Войти в Google"
4. Должен открыться стандартный экран Google Sign-In без ошибок
5. После входа создайте заметку
6. Проверьте папку Google Drive - должен появиться JSON файл с заметкой

## Возможные проблемы:
- Если все еще ошибка 10: проверьте правильность SHA-1 в Google Console
- Если ошибка доступа: убедитесь что аккаунт имеет права на папку Google Drive
- Если API ошибки: проверьте что Google Drive API включен в проекте