# BLE to Classic handover trace (Wireshark JSON)

## Timeline (key frames)
| Step | Frame | Dir | Opcode | Handle | Payload | Notes |
| --- | --- | --- | --- | --- | --- | --- |
| Primary service search (start) | 12264 | host→periph | 0x01 | 0x0014 | — | Read By Group Type start handle. |
| Primary service search (range) | 12270 | host→periph | 0x08 | 0x0023 | — | Continues discovery toward vendor handles. |
| CCCD enable (notify) | 12308 | host→periph | 0x12 | 0x0027 | — | Write Request to descriptor (notify enable 0x2902). |
| CCCD enable (indicate) | 12310 | host→periph | 0x12 | 0x0024 | — | Write Request to descriptor (indicate enable). |
| Start command (0x0611) | 12315 | host→periph | 0x52 | 0x0023 | 00 00 06 11 01 00 | Write Command to vendor write char (00002020…). |
| Vendor notify with device info | 12320 | periph→host | 0x1b | 0x0023 | 00 00 09 11 … | Notify on vendor notify char (00002001…). |
| Client-ready (0x0210) | 12321 | host→periph | 0x52 | 0x0023 | 00 00 02 10 … | Write Command to vendor write char. |
| Vendor ACK | 12322 | periph→host | 0x1b | 0x0023 | 00 00 03 00 | Notify confirming readiness. |
| Subsequent vendor stream | 12324+ | periph→host | 0x1b | 0x0023 | 00 00 09 10 … | Additional vendor notifications while waiting for BLE close. |

## Session ordering
1. Service discovery completes via Read By Group/Type spanning handles 0x0014–0x002f.【F:docs/wireshark_connection_report.md†L8-L15】
2. CCCD enablements target handles 0x0027 (notify) and 0x0024 (indicate) before any data writes.【F:docs/wireshark_connection_report.md†L16-L18】
3. Start command 00 00 06 11 01 00 is sent as Write Command (opcode 0x52) to handle 0x0023.【F:docs/wireshark_connection_report.md†L19-L20】
4. Device responds with notify payload 00 00 09 11… on handle 0x0023.【F:docs/wireshark_connection_report.md†L21-L22】
5. Client-ready frame 00 00 02 10… follows, then vendor ACK 00 00 03 00 on the same handle.【F:docs/wireshark_connection_report.md†L23-L24】
6. Device keeps sending vendor notifications (00 00 09 10…) until it closes BLE with status 22 (device-driven).【F:docs/wireshark_connection_report.md†L25-L26】

## Classic handover observation
The trace shows BLE traffic stopping after READY/ACK while the device controls the disconnect. Classic RFCOMM must begin only after the status=22 close; premature connects return read -1/timeout.
