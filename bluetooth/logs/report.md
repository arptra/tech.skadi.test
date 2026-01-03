# BLE Protocol Reverse Report (draft)

- Rows parsed: **425**
- Main connection handle: **0x0040**

## Top ATT attribute handles by frequency
| att_handle | count | share |
|---:|---:|---:|
| 0x0026 | 309 | 0.811 |
| 0x0023 | 41 | 0.108 |
| 0x0013 | 4 | 0.010 |
| 0x0027 | 4 | 0.010 |
| 0x0024 | 4 | 0.010 |
| 0x0001 | 3 | 0.008 |
| 0x0005 | 2 | 0.005 |
| 0x0014 | 2 | 0.005 |
| 0x002d | 2 | 0.005 |
| 0x0007 | 2 | 0.005 |
| 0x002c | 2 | 0.005 |
| 0x002f | 2 | 0.005 |
| 0x0003 | 1 | 0.003 |
| 0x0031 | 1 | 0.003 |
| 0x000c | 1 | 0.003 |
| 0x001a | 1 | 0.003 |

## Candidate channels
- TX (writes) candidate handle: **0x0026**
- RX (notify) candidate handles: **0x0026, 0x0023**

## CCCD-like writes (notify/indicate enable)
- Not detected by simple heuristic (payload 0100/0200/0000). Could be encrypted or different pattern.

## TX prefix clusters (first 2 bytes)
| prefix | count |
|---:|---:|
| 0000 | 35 |
| 0100 | 6 |

## Sequence field guess (TX payload positions)
- pos **7** score **0.157**
- pos **6** score **0.131**
- pos **2** score **0.106**

## TX→RX pairing (nearest response within 0.8s)
- Pairs found: **39** (saved to `pairs.csv`)

